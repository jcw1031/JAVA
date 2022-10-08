package fastcampus.designPattern.proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();

    }
}
