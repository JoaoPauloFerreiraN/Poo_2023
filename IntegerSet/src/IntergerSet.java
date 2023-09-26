public class IntergerSet {
    private boolean [] a = new boolean [101];

    IntergerSet union (IntergerSet j){
        IntergerSet b = new IntergerSet();
        for (int i = 0 ; i < this.a.length; i++){
            if ( j.a[i] || this.a[i]){
                b.a[i] = true;
            }
        }
        return b;
    }

    IntergerSet intersection (IntergerSet j){
        IntergerSet b = new IntergerSet();
        for (int i = 0 ; i < this.a.length; i++){
            if ( j.a[i] && this.a[i]){
                b.a[i] = true;
            }
        }
        return b;
    }

    void insertElement (int k){
        this.a [k] = true;
    }
    void deleteElement (int m){
        this.a[m] = false;
    }
    void toSetString (){
        int chave = 1;
        for(int i = 0; i < this.a.length ; i++ ){
            if (this.a[i]){
                chave += 1;
                System.out.print(" "+i);
            }
        }
        if(chave == 1){
            System.out.println("--");
        }else{
            System.out.println("");
        }
    }
    boolean isEqualTo (IntergerSet j){
        for(int i = 0; i < this.a.length ; i++ ){
            if (this.a[i] != j.a[i]) {
                //i = this.a.length + 1;
                return false;
            }
        }
        return true;
    }
}
