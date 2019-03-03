package dim.torgridson.blog.aspect;


import dim.torgridson.blog.model.Consumer;
import dim.torgridson.blog.model.ResultResponse;
import dim.torgridson.blog.model.exception.ConsumerNotFound;
import dim.torgridson.blog.model.exception.ResponseError;
import dim.torgridson.blog.model.exception.ResultCode;
import dim.torgridson.blog.model.exception.UnknownError;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HandlerExceptionAspect {

    @Around("@annotation(dim.torgridson.blog.anotation.CatchException)")
    public Object handler(ProceedingJoinPoint point) {
        Object result = null;
        try {
            result = point.proceed();
        } catch (ResponseError e) {
            return new ResultResponse<>(e.getResultCode());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return new ResultResponse<>(new UnknownError().getResultCode());
        }
        return result;
    }

}
