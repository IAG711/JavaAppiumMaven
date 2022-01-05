package Tests;

import Lib.CoreTestCase;
import Lib.Platform;
import Lib.UI.*;
import Lib.UI.Factories.ArticlePageObjectFactory;
import Lib.UI.Factories.MyListsPageObjectFactory;
import Lib.UI.Factories.NavigationUiFactory;
import Lib.UI.Factories.SearchPageObjectFactory;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {

    //EX.5
    @Test
    public void testSavingTwoArticles(){
        String reading_folder_name = "Reading list";
        String search_query = "Russia";
        String first_article = "Russia";
        String second_article = "Russian language";
        String login = "naxape3058";
        String password = "qwert12345qwert";

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        NavigationUI NavigationUI = NavigationUiFactory.get(driver);
        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.insertSearchQuery(search_query);
        SearchPageObject.openArticle(first_article);

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.waitForArticleTitleToAppear();
            ArticlePageObject.createReadingListAndAddArticle(reading_folder_name);
        } else if (Platform.getInstance().isIos()){
            ArticlePageObject.articleAddToReadingListClick();
            ArticlePageObject.closeAuthorizationModal();
        } else {
            ArticlePageObject.articleAddToReadingListClick();
        };

        if (Platform.getInstance().isMW()){
            AuthorizationPageObject AuthorizationPageObject = new AuthorizationPageObject(driver);
            AuthorizationPageObject.mwAuthorizationFromArticlePage(login, password);
        }

        ArticlePageObject.articleSearchBtnClick();

        if (Platform.getInstance().isAndroid() || Platform.getInstance().isMW()) {
            SearchPageObject.insertSearchQuery(search_query);
        }
        SearchPageObject.openArticle(second_article);

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.waitForArticleTitleToAppear();
            ArticlePageObject.addArticleIntoReadingList(reading_folder_name);
        } else {
            ArticlePageObject.articleAddToReadingListClick();
        };

        if (!Platform.getInstance().isMW()){
            ArticlePageObject.closeArticle();
        }

        NavigationUI.openReadingListsScreen();

        if (Platform.getInstance().isAndroid()) {
            MyListsPageObject.openReadingList(reading_folder_name);
        }

        MyListsPageObject.deleteArticleFromReadingList(second_article);
        MyListsPageObject.openArticleFromTheList(first_article);

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.waitForArticleTitleToAppear();
            ArticlePageObject.assertThatArticleHaveCorrectTitle(first_article);
        } else if (Platform.getInstance().isIos()){
            ArticlePageObject.assertThatArticleIsSaved();
        } else {
            //Добавил новую функцию для проверки, что зашли в нужную статью: в википедии заголовок статьи является частью url
            //поэтому после перехода в статью забираем урлу и проверяем, что нужное слово в ней встречается
            ArticlePageObject.checkArticleUrl(first_article);
        }
    }

    //EX.6
    @Test
    public void testAssertThatElementIsPresent(){
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.insertSearchQuery("Russia");
        SearchPageObject.openArticle("Russia");
        ArticlePageObject.assertTitleElementPresent();
    }

}
