package dim.torgridson.blog.anotation;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

@Target(METHOD)
public @interface CatchException {
}
