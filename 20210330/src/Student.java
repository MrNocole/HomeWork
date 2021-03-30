package src;

public class Student {
    private String stuID , stuName , stuSex , stuBirthday , stuLocation;
    private boolean ty;
    public Student (builder builder){
        this.stuID = builder.stuID;
        this.stuBirthday = builder.stuBirthday;
        this.stuName = builder.stuName;
        this.stuSex = builder.stuSex;
        this.stuLocation = builder.stuLocation;
        this.ty = builder.ty;
    }
    public static class builder{
        private String stuID , stuName , stuSex , stuBirthday , stuLocation;
        private boolean ty;
        public builder setStuID(String stuID){
            this.stuID = stuID;
            return this;
        }

        public builder setStuName(String stuName) {
            this.stuName = stuName;
            return this;
        }

        public builder setStuSex(String stuSex) {
            this.stuSex = stuSex;
            return this;
        }

        public builder setStuBirthday(String stuBirthday) {
            this.stuBirthday = stuBirthday;
            return this;
        }

        public builder setStuLocation(String stuLocation) {
            this.stuLocation = stuLocation;
            return this;
        }

        public builder setTy(boolean ty) {
            this.ty = ty;
            return this;
        }
        public builder(){}
        public Student build(){
            return new Student(this);
        }
    }

    public String getStuID() {
        return stuID;
    }

    public String getStuName() {
        return stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public String getStuBirthday() {
        return stuBirthday;
    }

    public String getStuLocation() {
        return stuLocation;
    }

    public boolean isTy() {
        return ty;
    }
}
