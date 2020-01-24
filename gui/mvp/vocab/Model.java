package gui.mvp.vocab;

//Speicher und logische verarbeitung
public class Model
{
    private String[] de =
    { "Wohnheim", "ein Junggeselle", "jemanden treffen", "sich gut fühlen", "sterben", "eine Konversation", "anfangen", "stolz", "würdig", "würde", "ehrlich", "Ehrlichkeit", "höflich", "Höflichkiet", "offen", "Offenheit", "Zuberlässigkeit", "großzügig", "Großzügigkeit", "loyal", "Loyalität", "tolerant", "Toleranz", "hilfsbereit", "Hilfsbereitschaft", "respektvoll", "Respekt" };

    private String[] eng =
    { "le foyer", "ein celibataire", "rejoindre qn", "se sentir a l' aise", "deceder", "une convocation", "débuter", "la fierté", "aigne", "la aigne", "nonnete", "la nonnetete", "la poli, e", "la politesse", "ouvert, e", "fiable", "genereux; euse", "la generosite", "loyal, e", "la loyaute", "tolerante, e", "la tolerance", "serivable", "la servibite", "respectueux", "le respect" };

    private int index = 0;

    public String getDe()
    {
        return this.de[this.index];
    }

    public String getEng()
    {
        return this.eng[this.index];
    }

    public Integer getIndex()
    {
        return this.index;
    }

    public boolean compare(String english)
    {
        return english.equals(this.eng[this.index]);
    }

    public void nextVocab()
    {
        if (this.index < this.de.length - 1)
        {
            this.index++;
        }
    }

}
