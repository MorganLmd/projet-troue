package com.m1iii.cybersecu.projettroue.Bootstrap;

import com.m1iii.cybersecu.projettroue.model.Book;
import com.m1iii.cybersecu.projettroue.model.User;
import com.m1iii.cybersecu.projettroue.repositories.BookRepository;
import com.m1iii.cybersecu.projettroue.repositories.UserRepository;
import com.m1iii.cybersecu.projettroue.security.ApplicationUserRole;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

import static com.m1iii.cybersecu.projettroue.security.ApplicationUserRole.*;

@AllArgsConstructor
@Component
public class Dataloader implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = User.builder()
                .address("1 rue Nationale 59000 Lille")
                .creditCardNumber("9876543210")
                .email("jean.dupont@gmail.com")
                .password(passwordEncoder.encode("password"))
                .userRole(CLIENT)
                .isAccountNonExpired(true)
                .isEnabled(true)
                .isCredentialNonExpired(true)
                .isAccountNonLocked(true)
                .username("jeandupont")
                .build();

        User user2 = User.builder()
                .address("12 rue de la clef 59000 Lille")
                .creditCardNumber("9876543210")
                .email("lise.durant@gmail.com")
                .password(passwordEncoder.encode("password"))
                .userRole(CLIENT)
                .isAccountNonExpired(true)
                .isEnabled(true)
                .isCredentialNonExpired(true)
                .isAccountNonLocked(true)
                .username("lisedurant")
                .build();

        User user3 = User.builder()
                .address("1 rue Nationale 59000 Lille")
                .creditCardNumber("9876543210")
                .email("admin@projettroue.com")
                .password(passwordEncoder.encode("password"))
                .userRole(ADMIN)
                .isAccountNonExpired(true)
                .isEnabled(true)
                .isCredentialNonExpired(true)
                .isAccountNonLocked(true)
                .username("morganlombard")
                .build();

        User user1Saved = userRepository.save(user1);
        User user2Saved = userRepository.save(user2);
       this.userRepository.save(user3);

        Book book1 = Book.builder()
                .author("Howard Phillips Lovecraft")
                .bookFormat("ebook")
                .description("From the Inside Flap of black magic unearthed unspeakable horrors in a quiet town near Providence, Rhode Island. Evil spirits are being resurrected from beyond the grave, a supernatural force so twisted that it kills without offering the mercy of death!")
                .isbn("978-0345354907")
                .publisher("Penguin Books")
                .title("The Case Of Charles Dexter Ward")
                .build();

        Book book2 = Book.builder()
                .author("Howard Phillips Lovecraft")
                .bookFormat("ebook")
                .description("Long acknowledged as a master of nightmarish visions, H. P. Lovecraft established the genuineness and dignity of his own pioneering fiction in 1931 with his quintessential work of supernatural horror, At the Mountains of Madness. The deliberately told and increasingly chilling recollection of an Antarctic expedition’s uncanny discoveries–and their encounter with untold menace in the ruins of a lost civilization–is a milestone of macabre literature.")
                .isbn("978-0812974416")
                .publisher("Modern Library")
                .title("At the Mountains of Madness")
                .build();

        Book book3 = Book.builder()
                .author("Frank Herbert")
                .bookFormat("ebook")
                .description("Set on the desert planet Arrakis, Dune is the story of the boy Paul Atreides, heir to a noble family tasked with ruling an inhospitable world where the only thing of value is the “spice” melange, a drug capable of extending life and enhancing consciousness. Coveted across the known universe, melange is a prize worth killing for...")
                .isbn("978-0441172719")
                .publisher("Ace")
                .title("Dune")
                .build();

        Book book1Saved = this.bookRepository.save(book1);
        Book book2Saved = this.bookRepository.save(book2);
        Book book3Saved = this.bookRepository.save(book3);

        user1Saved.setBooksOwned(new HashSet<>());
        user1Saved.getBooksOwned().add(book1Saved);
        user1Saved.getBooksOwned().add(book2Saved);
        this.userRepository.save(user1Saved);

        user2Saved.setBooksOwned(new HashSet<>());
        user2Saved.getBooksOwned().add(book2Saved);
        user2Saved.getBooksOwned().add(book3Saved);
        this.userRepository.save(user2Saved);
    }
}
