import java.util.ArrayList;
import java.util.Arrays;

public static class Notenverarbeitung {
    // punkt 1, Findet alle Noten, die nicht ausreichend sind (weniger als 40)

    public int[] findeNichtAusreichendeNoten(int[] noten) {
        ArrayList<Integer> nichtAusreichendeNoten = new ArrayList<>();
        for (int note : noten) {
            if (note < 40) {
                nichtAusreichendeNoten.add(note);
            }
        }
        // Konvertiere ArrayList zurück zu int[]
        return nichtAusreichendeNoten.stream().mapToInt(i -> i).toArray();
    }

    // punkt 2, Berechnet den Durchschnittswert aller Noten

    public double berechneDurchschnitt(int[] noten) {
        if (noten.length == 0) {
            return 0.0;
        }
        int summe = 0;
        for (int note : noten) {
            summe += note;
        }
        return (double) summe / noten.length;
    }

    // punkt 3, Ein Array mit den abgerundeten Noten zuruckgeben

    public int[] rundeNotenAb(int[] noten) {
        int[] abgerundeteNoten = new int[noten.length];
        for (int i = 0; i < noten.length; i++) {
            abgerundeteNoten[i] = rundeEinzelneNote(noten[i]);
        }
        return abgerundeteNoten;
    }

    private int rundeEinzelneNote(int note) {
        // Wenn die Note weniger als 38 ist, wird nicht aufgerundet.
        if (note < 38) {
            return note;
        }

        int naechstesVielfachesVon5 = ((note / 5) + 1) * 5;

        // Wenn die Differenz weniger als 3 ist, aufrunden.
        if (naechstesVielfachesVon5 - note < 3) {
            return naechstesVielfachesVon5;
        } else {
            return note;
        }
    }

    //punkt 4, maximale abgerundete Note zuruckgeben

    public int findeMaximaleAbgerundeteNote(int[] noten) {
        int[] abgerundeteNoten = rundeNotenAb(noten);
        int maxNote = Integer.MIN_VALUE;
        for (int note : abgerundeteNoten) {
            if (note > maxNote) {
                maxNote = note;
            }
        }
        return maxNote;
    }



}



public static void main(String[] args) {
    Notenverarbeitung notenverarbeitung = new Notenverarbeitung();
    int[] noten = {29, 37, 38, 41, 84, 67};

    // Teste findeNichtAusreichendeNoten
    int[] nichtAusreichendeNoten = notenverarbeitung.findeNichtAusreichendeNoten(noten);
    System.out.println("Nicht ausreichende Noten: " + Arrays.toString(nichtAusreichendeNoten));

    // Teste berechneDurchschnitt
    double durchschnitt = notenverarbeitung.berechneDurchschnitt(noten);
    System.out.println("Durchschnittsnote: " + durchschnitt);

    // Teste rundeNotenAb
    int[] abgerundeteNoten = notenverarbeitung.rundeNotenAb(noten);
    System.out.println("Abgerundete Noten: " + Arrays.toString(abgerundeteNoten));

    // Teste findeMaximaleAbgerundeteNote
    int maximaleAbgerundeteNote = notenverarbeitung.findeMaximaleAbgerundeteNote(noten);
    System.out.println("Maximale abgerundete Note: " + maximaleAbgerundeteNote);
}