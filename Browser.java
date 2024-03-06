public class Browser {
    static Tab currTab;
    static Page currPage;
    static Page historyPage1;
    static Page historyPage2;

    public class Tab {
        String tabName;
        Tab nextTab;

        Tab(String tabName) {
            this.tabName = tabName;

        }

    }

    public class Page {
        String url;
        Page prevPage;
        Page nextPage;

        Page(String url) {
            this.url = url;
            this.prevPage = currPage;
            this.nextPage = null;
        }

    }

    Browser() {
        Tab tab1 = new Tab("tab1");
        Tab tab2 = new Tab("tab2");
        Page page1 = new Page("HomePage");
        Page page2 = new Page("HomePage");

        tab1.nextTab = tab2;
        tab2.nextTab = tab1;
        currTab = tab1;

        historyPage1 = page1;
        historyPage2 = page2;
        // current pages

        currPage = page1;
    }

    void visit(String url) {
        Page page = new Page(url);

        if (currPage == historyPage1) {
            currPage.nextPage = page;
            currPage = currPage.nextPage;
            historyPage1 = currPage;
        } else {
            currPage.nextPage = page;
            currPage = currPage.nextPage;
            historyPage2 = currPage;
        }

    }

    String go_back(int n) {
        if (currPage == historyPage1) {
            for (int i = 0; i < n; i++) {
                if (currPage.prevPage == null) {
                    historyPage1 = currPage;
                    return currPage.url;
                }

                currPage = currPage.prevPage;
            }
            historyPage1 = currPage;

        } else {
            for (int i = 0; i < n; i++) {
                if (currPage.prevPage == null) {
                    historyPage2 = currPage;
                    return currPage.url;
                }

                currPage = currPage.prevPage;
            }
            historyPage2 = currPage;

        }
        return currPage.url;
    }

    String forward(int n) {
        if (currPage == historyPage1) {
            for (int i = 0; i < n; i++) {

                if (currPage.nextPage == null) {

                    historyPage1 = currPage;
                    return currPage.url;

                }

                currPage = currPage.nextPage;
            }
            historyPage1 = currPage;
        } else {
            for (int i = 0; i < n; i++) {

                if (currPage.nextPage == null) {

                    historyPage2 = currPage;
                    return currPage.url;

                }

                currPage = currPage.nextPage;
            }
            historyPage2 = currPage;
        }
        return currPage.url;
    }

    void changeTab() {

        if (currPage == historyPage1) {
            currPage = historyPage2;
        } else {
            currPage = historyPage1;
        }

        currTab = currTab.nextTab;

    }

    public static void main(String[] args) {
        Browser browser = new Browser();
        // current url
        System.out.println(browser.currPage.url);
        browser.visit("www.google.com");
        browser.visit("www.google.com/1");
        browser.visit("www.google.com/2");
        browser.visit("www.google.com/3");
        browser.visit("www.google.com/4");

        // current page
        System.out.println(browser.currPage.url);
        // back 2 pages
        browser.go_back(2);
        // current page
        System.out.println(browser.currPage.url);

        // forward 1 page
        browser.forward(1);
        // current page
        System.out.println(browser.currPage.url);

        // change tab
        browser.changeTab();
        System.out.println("changing Tab");
        System.out.println(currPage.url);

        browser.visit("www.youTube.com");
        browser.visit("www.youTube.com/1");
        browser.visit("www.youTube.com/2");
        browser.visit("www.youTube.com/3");
        browser.visit("www.youTube.com/4");

        System.out.println(currPage.url);
        // back 2 pages
        browser.go_back(2);
        // current page
        System.out.println(browser.currPage.url);

        // forward 1 page
        browser.forward(1);
        // current page
        System.out.println(browser.currPage.url);

        // change tab

        browser.changeTab();
        System.out.println("changing Tab");
        System.out.println(currPage.url);
        // forward 1 page
        browser.forward(1);
        // current page

        System.out.println(currPage.url);

    }
}
