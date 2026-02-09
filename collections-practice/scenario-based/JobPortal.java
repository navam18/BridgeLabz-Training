import java.util.*;
class InvalidResumeException extends Exception{
    InvalidResumeException(String msg){
        super(msg);
    }
}
class Resume{
    String name;
    Set<String> skills;
    int matches;
    Resume(String name,Set<String>skills)throws InvalidResumeException{
        if(skills==null||skills.isEmpty()){
            throw new InvalidResumeException("Skill set is empty");
        }
        this.name=name;
        this.skills=skills;
    }
    void calculateMatches(Set<String> requiredSkills){
        int count=0;
        for(String skill:skills){
            if(requiredSkills.contains(skill)){
                count++;
            }
        }
        this.matches=count;
    }
}
class ResumeCompare implements Comparator<Resume>{
    public int compare(Resume r1,Resume r2){
        return r2.matches - r1.matches;
    }
}
class JobPortal{
    public static void main(String args[]){
        try{
            Set<String> requiredSkills=new HashSet<>();
            requiredSkills.add("Java");
            requiredSkills.add("DSA");
            requiredSkills.add("SQL");
            List<Resume>resumes=new ArrayList<>();
            resumes.add(new Resume("Navam",new HashSet<>(Arrays.asList("Java", "DSA", "SQL"))));
            resumes.add(new Resume("Aryan",new HashSet<>(Arrays.asList("Java", "SQL"))));
            resumes.add(new Resume("Moon",new HashSet<>(Arrays.asList("SQL", "DSA"))));
            resumes.add(new Resume("Ayush",new HashSet<>(Arrays.asList("Java"))));
            for(Resume r:resumes){
                r.calculateMatches(requiredSkills);
            }
            resumes.sort(new ResumeCompare());
            for(Resume r:resumes){
                System.out.println(r.name+" "+r.matches);
            }
        }
        catch(InvalidResumeException e){
            System.out.println(e.getMessage());
        }
    }
}