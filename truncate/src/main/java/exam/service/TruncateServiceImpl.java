package exam.service;

import org.springframework.stereotype.Service;


@Service
public class TruncateServiceImpl implements TruncateService {

    private static final String REPLACE_STRING = " ... (truncated) ... "; //21 characters long
    private static final int REPLACE_STRING_LENGTH = REPLACE_STRING.length();

    public String truncate(String s, int limit) {
        int sl = s.length();
        if (sl > limit && limit > REPLACE_STRING_LENGTH) {
            int lettersToKeepAtEnd = (limit - REPLACE_STRING_LENGTH) / 2;
            return s.substring(0, lettersToKeepAtEnd) + REPLACE_STRING + s.substring(sl - lettersToKeepAtEnd, sl);
        } else {
            return s;
        }
    }
}
