package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

import java.util.List;

public class MoviePage {

    WebDriver driver;

    // Recommended Movies section → list of movies
//    @FindBy(xpath = "//div[@id='recommended-movies']//div[contains(@class,'movie-card')]")
    @FindBy(xpath = "//div[contains(@class,'sc-133848s-3')]//a[@class='sc-133848s-11 sc-lnhrs7-5 ctsexn bHVBt']")
    private List<WebElement> recommendedMovies;

    // Movie details page elements
    @FindBy(xpath = "//h1[@class='movie-title']")
    private WebElement movieName;

    @FindBy(xpath = "//img[@class='movie-poster']")
    private WebElement moviePoster;

    @FindBy(xpath = "//button[contains(text(),'Book Tickets')]")
    private WebElement bookingOption;

    // Movies tab
//    @FindBy(xpath = "//a[contains(text(),'Movies')]")
    @FindBy(xpath = "//a[text()='Movies']")
    private WebElement moviesTab;

    // Explore Upcoming Movies link
//    @FindBy(xpath = "//a[contains(text(),'Explore Upcoming Movies')]")
    @FindBy(xpath = "//img[@alt='Coming Soon']")
    private WebElement exploreUpcomingMoviesImgLink;

    // "In Cinemas Near You" link
//    @FindBy(xpath = "//a[contains(text(),'In Cinemas Near You')]")
    @FindBy(xpath = "//img[@alt='Now Showing']")
    private WebElement inCinemasNearYouImgLink;

    // ✅ Constructor
    public MoviePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Select first movie from recommended list
    public void selectFirstRecommendedMovie() {
        if (!recommendedMovies.isEmpty()) {
            recommendedMovies.get(0).click();
        } else {
            throw new RuntimeException("No recommended movies found!");
        }
    }

//    // Get movie name
    public boolean isMovieNameDisplayed() {
        return movieName.isDisplayed();
    }

    // Check if poster is visible
    public boolean isPosterDisplayed() {
        return moviePoster.isDisplayed();
    }

    // Check if booking option is available
    public boolean isBookingOptionAvailable() {
        return bookingOption.isDisplayed();
    }

    // Navigate to Movies tab
    public void clickMoviesTab() {
        moviesTab.click();
    }

    // Navigate to Explore Upcoming Movies
    public void clickExploreUpcomingMovies() {
    	WaitUtils.waitForClickability(driver, exploreUpcomingMoviesImgLink).click();
//    	exploreUpcomingMoviesImgLink.click();
    }

    // Validate "In Cinemas Near You" link
    public boolean isInCinemasNearYouLinkDisplayed() {
    	return WaitUtils.waitForVisibility(driver, inCinemasNearYouImgLink).isDisplayed();
    }
}
