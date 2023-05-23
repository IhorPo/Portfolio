package com.project_1.university.enums;

public enum Lesson {
    ENGLISH{
        @Override
        public String toString(){
            return "English";
        }
    },
    MATH{
        @Override
        public String toString(){
            return "Math";
        }
    },
    HISTORY{
        @Override
        public String toString(){
            return "History";
        }
    },
    PSYCHOLOGY{
        @Override
        public String toString(){
            return "Psychology";
        }
    }
}
