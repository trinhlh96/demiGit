package testmysql.etity;

public class Article {
    private int id;
    private String title;
    private String url;
    private String description;
    private String contest;
    private String source;
    private int status;

    public Article(int id, String title, String url, int status) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.status = status;
    }

    public Article() {
    }

    public Article(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return String.format("Tiêu đề: %s\nMô tả: %s\nNội dung: %s\nNguồn: %s\n",title, description, contest, source);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContest() {
        return contest;
    }

    public void setContest(String contest) {
        this.contest = contest;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
