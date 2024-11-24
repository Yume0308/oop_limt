package com.limt.Controllers;

import com.google.gson.*;
import com.limt.Models.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddBookWithApiPageController implements Initializable {

    @FXML
    private Button addSelectedBoxBtn;

    @FXML
    private TableColumn<Book, String> authorCol;

    @FXML
    private TableView<Book> bookTableView;

    @FXML
    private TableColumn<Book, String> categoryCol;

    @FXML
    private Button clearTableView;

    @FXML
    private TableColumn<Book, String> isbnCol;

    @FXML
    private TableColumn<Book, String> publisherCol;

    @FXML
    private TextField searchBookTitleField;

    @FXML
    private Button submitSearchBtn;

    @FXML
    private TableColumn<Book, String> titleCol;

    @FXML
    private TableColumn<Book, Integer> quantityCol;

    @FXML
    private TableColumn<Book, Integer> remainingCol;

    @FXML
    private TableColumn<Book, Integer> imagePathCol;

    private ObservableList<Book> bookList = FXCollections.observableArrayList();

    @FXML
    void HandleAddSelectedBox(ActionEvent event) {

    }

    @FXML
    void HandleClearTableView(ActionEvent event) {
        bookTableView.getItems().clear();
    }

    @FXML
    void HandleSearchBookTitleWithApi(ActionEvent event) {
        String query = searchBookTitleField.getText();
        if(query.isEmpty())
        {
            System.out.println("Invalid query");
            return;
        }

        String ApiKey = "AIzaSyDZzVvq_zRa2dMBFdapShHbQANDTVhCMY4";
        String ApiURL = "https://www.googleapis.com/books/v1/volumes?q=" + query + "&maxResults=20&key=";

        try {
            // GET Method Request
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(new URI(ApiURL)).GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Thread.sleep(3 * 1000);

            if(response.statusCode() == 200) {
                String responseBody = response.body();
                ArrayList<Book> books = HandleParseBookInfoFromApi(responseBody);

                bookList.setAll(books);
            } else {
                System.out.println("Failed");
            }

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    ArrayList<Book> HandleParseBookInfoFromApi(String json) {
        ArrayList<Book> books = new ArrayList<>();
        Gson gson = new Gson();

        try {
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
            JsonArray items = jsonObject.getAsJsonArray("items");

            for(JsonElement item : items) {
                JsonObject itemObject = item.getAsJsonObject();
                JsonObject volumeInfo = itemObject.getAsJsonObject("volumeInfo");

                String isbn = "N/A";
                String title = volumeInfo.has("title") ? volumeInfo.get("title").getAsString() : "Unknown Title";
                if (volumeInfo.has("industryIdentifiers")) {
                    JsonArray isbnIdentifier = volumeInfo.getAsJsonArray("industryIdentifiers");
                    for(JsonElement value : isbnIdentifier) {
                        JsonObject isbnObject = value.getAsJsonObject();
                        if(isbnObject.get("type").getAsString().equals("ISBN_10")) {
                            isbn = isbnObject.get("identifier").getAsString();
                            break;
                        }
                    }

                }

                String author = volumeInfo.has("authors") ? volumeInfo.get("authors").getAsJsonArray().get(0).getAsString() : "Unknown Author";
                String category = volumeInfo.has("categories") ? volumeInfo.get("categories").getAsJsonArray().getAsString() : "Unknown Category";
                String publisher = volumeInfo.has("publisher") ? volumeInfo.get("publisher").getAsString() : "Unknown Publisher";
                String imagePath =  volumeInfo.has("imageLinks") ? volumeInfo.getAsJsonObject("imageLinks").get("thumbnail").getAsString() : "N/A";

                books.add(new Book(isbn, title, author, category, publisher, 0, 0, imagePath));
                bookTableView.setItems(bookList);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    private void InitializeAllColumns() {
        isbnCol.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("Author"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("Category"));
        publisherCol.setCellValueFactory(new PropertyValueFactory<>("Publisher"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        InitializeAllColumns();
        bookTableView.getItems().clear();
    }
}
