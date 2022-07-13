package Parser;

import java.util.regex.Pattern;

public class ParserRegex {
    String cirillicAndSymbolsRegex = "[а-яёА-ЯЁ\s-]+";
//  String numberRegex = "[0-9]+";
    String cirillicAndEmptyRegexs = "^$|[а-яёА-ЯЁ]+";
    String telegramNickNameRegex = ".*\\B@(?=\\w{5,64}\\b)[a-zA-Z0-9]+(?:_[a-zA-Z0-9]+)*.*";
    String telegramNickNameWithoutSymbolsRegex = ".*\\B(?=\\w{5,64}\\b)[a-zA-Z0-9]+(?:_[a-zA-Z0-9]+)*.*";


    Pattern cirillicAndSymbolsPattern = Pattern.compile(cirillicAndSymbolsRegex);
 // Pattern numberPattern = Pattern.compile(numberRegex);
    Pattern cirillicAndEmptyPattern = Pattern.compile(cirillicAndEmptyRegexs);
    Pattern telegramNickNamePattern = Pattern.compile(telegramNickNameRegex);
    Pattern telegramNickNameWithoutSymbolsPattern = Pattern.compile(telegramNickNameWithoutSymbolsRegex);
}