package crm.ks.CRM.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
public class UniqueCodeService {
    private static final SecureRandom random = new SecureRandom();
    private static final Set<Integer> usedNumbers = new HashSet<>();

    public int generateUniqueThreeDigit() {
        if (usedNumbers.size() >= 900) {
            throw new IllegalStateException("All 3-digit numbers exhausted");
        }

        int number;
        do {
            number = random.nextInt(900) + 100; // 100-999
        } while (usedNumbers.contains(number));

        usedNumbers.add(number);
        return number;
    }
}
