package spittr.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by shucheng on 2020/7/7 17:44
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,
                reason = "Spittle Not Found")
public class SpittleNotFoundException extends RuntimeException {
}
