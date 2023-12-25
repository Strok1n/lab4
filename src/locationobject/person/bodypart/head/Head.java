package locationobject.person.bodypart.head;

import enumeration.GazeModifier;
import enumeration.HairColor;
import geometry.Point;
import locationobject.Listenable;
import locationobject.Listener;
import locationobject.LocationObject;
import locationobject.Observer;
import locationobject.person.ObjectOnShoulder;
import locationobject.person.Person;
import locationobject.person.bodypart.head.mouth.LipsType;

import java.util.ArrayList;

public abstract class Head implements ObjectOnShoulder, Observer {
    protected GazeModifier gazeModifier;

    protected Mouth mouth;

    protected ArrayList<Tear> tears;

    protected int inclinationAngleInDegrees;

    protected Point pointILookingAt;
    HairColor hairColor;

    protected Head(HairColor hairColor, Mouth mouth){
        this.gazeModifier = GazeModifier.NORMAL;
        this.tears = new ArrayList<>();
        this.inclinationAngleInDegrees = 0;
        this.hairColor = hairColor;
        this.mouth = mouth;
    }

    public Point getPointILookingAt() {
        return pointILookingAt;
    }

    public void setPointILookingAt(Point pointILookingAt) {
        this.pointILookingAt = pointILookingAt;
    }

    @Override
    public void handleEvent(Point point) throws InterruptedException {
        this.pointILookingAt = point;
    }

    public Mouth getMouth() {
        return mouth;
    }

    public void cry(){
        for (int i = 0; i < 4; i++)
            this.tears.add(new Tear());
    }

    public void wipeTearsAway(){
        this.tears.clear();
    }

    public void nod() throws InterruptedException {
        System.out.println("Inclination angle of head:");
        for (int i = 0; i < 25; i++) {
            inclinationAngleInDegrees++;


            System.out.print(inclinationAngleInDegrees);
            Thread.sleep(100);
            System.out.print("\r");
            System.out.print("\r");
        }

        for (int i = 0; i < 25; i++) {
            inclinationAngleInDegrees--;
            System.out.print(inclinationAngleInDegrees);
            Thread.sleep(100);
            System.out.print("\r");
            System.out.print("\r");
        }
        System.out.println(inclinationAngleInDegrees);
    }

    public GazeModifier getGazeModifier() {
        return gazeModifier;
    }
    public void setGazeModifier(GazeModifier gazeModifier) {
        this.gazeModifier = gazeModifier;
    }

    static public class Mouth extends LocationObject implements Listenable {

        protected ArrayList<Person> listeners;
        protected LipsType lipsType;
        protected int voiceLoudnessLevel;
        protected Character pronounceableLetter;

        protected int pauseLengthAfterLetter;
        protected int pauseLengthAfterWord;
        protected int pauseLengthAfterComma;
        protected int pauseLengthAfterPoint;

        public Mouth(LipsType lipsType, int voiceLoudnessLevel,
                     int pauseLengthAfterLetter,int pauseLengthAfterWord,
                     int pauseLengthAfterComma, int pauseLengthAfterPoint){
            this.listeners = new ArrayList<>();
            this.voiceLoudnessLevel = voiceLoudnessLevel;
            this.lipsType = lipsType;
            this.pauseLengthAfterLetter = pauseLengthAfterLetter;
            this.pauseLengthAfterWord = pauseLengthAfterWord;
            this.pauseLengthAfterComma = pauseLengthAfterComma;
            this.pauseLengthAfterPoint = pauseLengthAfterPoint;
        }
        protected void pronounceLetter(char letter) throws InterruptedException {
            this.pronounceableLetter = letter;
            this.notifyListeners(letter);
            makePauseAfterLetter();
            System.out.print(letter);
        }

        public void sayAText(String sentence) throws InterruptedException {
            for (char c:
                    sentence.toCharArray()) {
                if (c == ' ' || c == ',' || c == '.') {
                    if (c == ' ') {
                        makePauseAfterWord();
                        this.notifyListeners(' ');
                        System.out.print(" ");
                    }
                    if (c == ',') {
                        makePauseAfterComma();
                        this.notifyListeners(',');
                        System.out.print(",");
                    }
                    if (c == '.') {
                        makePauseAfterPoint();
                        System.out.println(".");
                        this.notifyListeners('.');

                    }
                } else {
                    pronounceLetter(c);
                }
            }
            this.pronounceableLetter = null;
        }

        protected void makePauseAfterLetter() throws InterruptedException {
            Thread.sleep( pauseLengthAfterLetter);
        }
        protected void makePauseAfterWord() throws InterruptedException {
            Thread.sleep( pauseLengthAfterWord);
        }

        protected void makePauseAfterPoint() throws InterruptedException {
            Thread.sleep(pauseLengthAfterPoint);
        }

        protected void makePauseAfterComma() throws InterruptedException {
            Thread.sleep(pauseLengthAfterComma);
        }

        @Override
        public void addListener(Listener listener) {
            this.listeners.add((Person) listener);
        }

        @Override
        public void removeListener(Listener listener) {
            this.listeners.remove((Person) listener);
        }

        @Override
        public void notifyListeners(Character character) throws InterruptedException {
            for (Person observer: this.listeners) {
                if (this.point.distanceSquared(observer.getPoint()) <= (this.voiceLoudnessLevel*this.voiceLoudnessLevel)) {
                    if (character == '.') {
                        System.out.println(observer + " heard the proposal.");
                    }
                    observer.handleEvent(character);
                }
            }
        }

    }




}
