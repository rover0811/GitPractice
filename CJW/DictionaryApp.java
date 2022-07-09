abstract class PairMap{
    protected String keyArray []; //key 들을 저장하는 배열
    protected String valueArray []; //value 들을 저장하는 배열
    abstract String get(String key); //key 값을 가진 value 리턴. 없으면 null 리턴
    abstract void put(String key, String value); //key와 value를 쌍으로 저장.
                                                //기존에 key가 있으면, 값을 value로 수정
    abstract String delete(String key); //key값을 가진 아이템(value와 함께) 삭제.
                                        //삭제된 value 값 리턴
    abstract int length(); //현재 저장된 아이템의 개수 리턴
}
class Dictionary extends PairMap
{
    int capacity;
    int cnt=0;

    public Dictionary(int capacity){
        this.capacity = capacity;
        keyArray = new String[capacity];
        valueArray = new String[capacity];
    }
    @Override
    public String get(String key){
        for(int i=0;i<capacity;i++){
            if(key.equals(keyArray[i]))
                return valueArray[i];
        }
        return null;
    }
    @Override
    public void put(String key, String value){
        //배열 용량 다 찼을 경우
        if(cnt==capacity){
            System.out.println("배열 용량 부족");
            return;
        }
        //배열에 동일한 key 값 존재하는 경우
        for(int i=0;i<cnt;i++){
            if(key.equals(keyArray[i])) {
                valueArray[i] = value;
                return;
            }
        }
        //배열에 추가하는 경우
        keyArray[cnt] = key;
        valueArray[cnt++] = value;
    }
    @Override
    public String delete(String key){
        for(int i=0;i<cnt;i++){
            if(key.equals(keyArray[i])){
                String tmp = valueArray[i];
                keyArray[i] = "null";
                valueArray[i] = "null";
                cnt--;
                return tmp;
            }
        }
        return null;
    }
    @Override
    public int length(){
        return cnt;
    }
}


public class DictionaryApp {
    public static void main(String[] args) {
        Dictionary dic  = new Dictionary(10);
        dic.put("황기태","자바");
        dic.put("이재문","파이선");
        dic.put("이재문","C++"); //이재문의 값을 C++로 수정
        System.out.println("이재문의 값은 " + dic.get("이재문"));
        System.out.println("황기태의 값은 " + dic.get("황기태"));
        dic.delete("황기태");
        System.out.println("황기태의 값은 "+dic.get("황기태")); //삭제된 아이템 접근
    }
}

