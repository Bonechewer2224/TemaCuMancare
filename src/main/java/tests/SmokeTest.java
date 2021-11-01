package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.TestNgListener;

@Listeners(TestNgListener.class)

public class SmokeTest extends BaseTest {

    @Test(priority = 0)
    public void navigateToBlogsAndCheckNr() {
        page.navPage.navigateTo(page.navPage.blogLink);
        page.blogPage.checkNumberOfBlogPosts();
    }

    @Test(priority = 1)
    public void openAllBlogsAndAddComment() throws InterruptedException{
        for (int i = 0; i < page.blogPage.blog.size(); i++) {
            page.navPage.navigateTo(page.navPage.blogLink);
            page.blogPage.click(page.blogPage.blog.get(i));
            page.blogPage.addCommentAndVerify();
            page.navPage.navigateTo(page.navPage.blogLink);
        }
    }
}
