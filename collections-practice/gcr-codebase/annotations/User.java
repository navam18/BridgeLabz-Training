
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class UserC {

    @MaxLength(10)
    String username;

    UserC(String username) {
        if (username.length() > 10)
            throw new IllegalArgumentException("Username too long");
        this.username = username;
    }
}

