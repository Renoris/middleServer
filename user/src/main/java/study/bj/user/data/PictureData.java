package study.bj.user.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.File;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="picture")
public class PictureData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String image;
    private String ProductName;
    private String Tag;
    private String ShoppingMall;
    private int Price;
    private String Logo;
}
