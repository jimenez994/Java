package zeus.jim;

public class Song {
    private String title;
    private Double duration;

    public Song(String title, double duration) {
        if(title.isEmpty()){
            System.out.println("Title cannot be empty");
        }else if(duration < 0 ){
            System.out.println("Duration must be more than 0");
        }else{
            this.title = title;
            this.duration = duration;
        }
    }

    @Override
    public String toString() {
        return "Title: " + title + " \n" +"Duration: " + duration;
    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }
}
