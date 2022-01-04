package Tests;

import Lib.CoreTestCase;
import Lib.Platform;
import Lib.UI.ArticlePageObject;
import Lib.UI.Factories.ArticlePageObjectFactory;
import Lib.UI.Factories.MyListsPageObjectFactory;
import Lib.UI.Factories.NavigationUiFactory;
import Lib.UI.Factories.SearchPageObjectFactory;
import Lib.UI.MyListsPageObject;
import Lib.UI.NavigationUI;
import Lib.UI.SearchPageObject;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {

    //EX.5
    @Test
    public void testSavingTwoArticles(){
        String reading_folder_name = "Reading list";
        String search_query = "Russia";
        String first_article = "Russia";
        String second_article = "Russian language";

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
        } else {
            ArticlePageObject.articleAddToReadingListClick();
            ArticlePageObject.closeAuthorizationModal();
        }

        ArticlePageObject.articleSearchBtnClick();

        if (Platform.getInstance().isAndroid()) {
            SearchPageObject.insertSearchQuery(search_query);
        }
        SearchPageObject.openArticle(second_article);

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.waitForArticleTitleToAppear();
            ArticlePageObject.addArticleIntoReadingList(reading_folder_name);
        } else ArticlePageObject.articleAddToReadingListClick();

        ArticlePageObject.closeArticle();
        NavigationUI.openReadingListsScreen();
        if (Platform.getInstance().isAndroid()) {
            MyListsPageObject.openReadingList(reading_folder_name);
        }

        MyListsPageObject.deleteArticleFromReadingList(second_article);
        MyListsPageObject.openArticleFromTheList(first_article);

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.waitForArticleTitleToAppear();
            ArticlePageObject.assertThatArticleHaveCorrectTitle(first_article);
        } else {
            //Часть задания про "придумать другой способ проверки, исключив проверку title". В голову пришел только такой вариант:
            //Проверка, по сути, состоит из двух "шагов": Первый выполняется когда мы открываем саму статью (если её не останется в списке после удаления - она не откроется)
            //Второй сделан тут: идет проверка, что после открытия статьи, в ней есть элемент удаления из списка чтения
            //т.е. если открывшаяся в тесте статья не была в списке сохраненных - будет ошибка
            ArticlePageObject.assertThatArticleIsSaved();
        }
    }

    //EX.6
//    @Test
//    public void testAssertThatElementIsPresent(){
//        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
//        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
//
//        SearchPageObject.initSearchInput();
//        SearchPageObject.insertSearchQuery("Russia");
//        SearchPageObject.openArticle("Russia");
//        ArticlePageObject.assertTitleElementPresent();
//    }

}
