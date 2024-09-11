package dev.kesorupert.imdb_overview.view;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import dev.kesorupert.imdb_overview.model.Episode;
import dev.kesorupert.imdb_overview.service.SeriesRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and use @Route
 * annotation to announce it in a URL as a Spring managed bean.
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 * <p>
 * The main view contains a text field for getting the user name and a button
 * that shows a greeting message in a notification.
 */
@Route
public class MainView extends VerticalLayout {

    private TextField searchField;
    private Button searchButton;
    private Div seriesInfo;
    private Grid<Episode> ratingsGrid;
    private Div colorLegend;

    public MainView(@Autowired SeriesRetrievalService service) {

        createSearchBar();

        // Use custom CSS classes to apply styling. This is defined in
        // styles.css.
        addClassName("centered-content");

        add(new HorizontalLayout(searchField, searchButton));
    }

    private void createSearchBar() {
        searchField = new TextField();
        searchField.setPlaceholder("Search for a series");
        searchField.setClearButtonVisible(true);

        searchButton = new Button("Search", e -> performSearch());
//        searchButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        searchButton.addClickShortcut(Key.ENTER);
    }

    private void performSearch() {
        String searchTerm = searchField.getValue();

        // TODO
    }

    private void createSeriesInfo() {
        seriesInfo = new Div();
        seriesInfo.addClassName("series-info");
        seriesInfo.setWidth("300px"); // We can also set the width in styles.css with above classname?
    }

}
