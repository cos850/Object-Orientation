package server.httpserver;


public interface MyHttpServer {
    // 생성 -> 생성자

    // 설정
    void setContext(String path, String responseData);

    // 시작
    void start();
}
