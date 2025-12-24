public class OnlineCourse extends Course {
    private String platform;

    // Constructor calling super
    public OnlineCourse(String courseCode, String title, String platform) {
        super(courseCode, title);
        this.platform = platform;
    }

    // Override showDetails
    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Platform: " + platform);
    }
}