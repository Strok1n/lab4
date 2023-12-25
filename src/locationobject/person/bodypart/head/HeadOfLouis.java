package locationobject.person.bodypart.head;

import enumeration.HairColor;
import locationobject.person.bodypart.head.mouth.LipsType;

public class HeadOfLouis extends Head {
    public HeadOfLouis(){
        super(
                HairColor.MEDIUM_BROWN,
                new Mouth(
                        LipsType.THIN,
                        8,
                        20,
                        143,
                        450,
                        1120
                )
        );
    }
}
