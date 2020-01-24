package gui.mvp.quiz.dragdrop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Model
{
    private HashMap<List<String>, String> questionMap = new HashMap<>();
    private HashMap<Integer, String> answerMap = new HashMap<>();
    private List<String> frageList = new ArrayList<>();
   
    public void addQuestion( List<String> answers, String question) {
        questionMap.put(answers, question);
    }
    
    public void addAnswer(int position, String answer) {
        answerMap.put(position, answer);
        System.out.println(answerMap.get(position));
    }
    
    public List<String> getAllQuestions() {
        return this.frageList;
    }
    
    public HashMap<List<String>, String> getQuestionMap() {
        return questionMap;
    }
    
    public HashMap<Integer, String> getAnswerMap(){
        return answerMap;
    }
    // Eine Methode mit der Man immer eine HashMap erzeugen kann 
    public HashMap<Integer, String> createHashMap() {
        HashMap<Integer, String> tmp = new HashMap<>();
        return tmp;
    }
    
    
    
}
