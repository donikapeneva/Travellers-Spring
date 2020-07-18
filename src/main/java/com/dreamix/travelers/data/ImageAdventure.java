package com.dreamix.travelers.data;

import lombok.*;

import javax.persistence.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "image")
public class ImageAdventure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String type;
    private byte[] source;
    @Column(name="adventure_id")
    private int adventureId;

    @ManyToOne
    @JoinColumn(name="adventure_id", nullable=false, insertable=false, updatable=false)
    private Adventure adventure;

    public ImageAdventure(String title, String type, byte[] source, int adventureId) {
        this.title = title;
        this.type = type;
        this.source = source;
        this.adventureId = adventureId;
    }

}
