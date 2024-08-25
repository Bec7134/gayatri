

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bfhl")
public class ApiController {

    @GetMapping
    public OperationCode getOperationCode() {
        return new OperationCode(1);
    }

    @PostMapping
    public ApiResponse postData(@RequestBody DataRequest request) {
        List<String> numbers = request.getData().stream().filter(this::isNumeric).collect(Collectors.toList());
        List<String> alphabets = request.getData().stream().filter(this::isAlphabetic).collect(Collectors.toList());
        List<String> lowercaseAlphabets = alphabets.stream().filter(this::isLowercase).collect(Collectors.toList());

        String highestLowercaseAlphabet = lowercaseAlphabets.stream().max(String::compareTo).orElse(null);

        return new ApiResponse(
                true,
                "john_doe_17091999",
                "john@xyz.com",
                "ABCD123",
                numbers,
                alphabets,
                highestLowercaseAlphabet != null ? List.of(highestLowercaseAlphabet) : List.of()
        );
    }

    private boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    private boolean isAlphabetic(String str) {
        return str.chars().allMatch(Character::isLetter);
    }

    private boolean isLowercase(String str) {
        return str.chars().allMatch(Character::isLowerCase);
    }
}