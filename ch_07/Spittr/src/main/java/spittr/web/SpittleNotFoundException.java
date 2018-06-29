package spittr.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-21 20:40
 * Description: @ResponseStatus注解，将异常映射为特定的状态码
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Spittle Not Found")
public class SpittleNotFoundException extends RuntimeException {
}
