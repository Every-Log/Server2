package tteokbokki.everylog.domain;

public enum PostType {
    Diary("D"),
    Travel("T"),
    Review("R"),
    Study("S");

    private final String postTypeKey;

    PostType(String postTypeKey) {
        this.postTypeKey = postTypeKey;
    }

    //String인 Post Type Key를 넣으면 PostType으로 변환해준다.
    //예를 들어 "D"를 넣으면 PostType인 DIARY로 바꿔준다.
    public static PostType fromString(String postTypeKey) {
        for (PostType i : PostType.values()) {
            if (i.postTypeKey.equalsIgnoreCase(postTypeKey)) {
                return i;
            }
        }
        return  null;
    }
}
