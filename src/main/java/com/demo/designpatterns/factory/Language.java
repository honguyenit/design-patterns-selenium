package com.demo.designpatterns.factory;

    public enum Language {
        EN("english"),
        FR("français"),
        SP("español");

        private final String languageName;

        Language(String languageName) {
            this.languageName = languageName;
        }

        public String getLanguageName() {
            return languageName;
        }

        public static Language fromCode(String languageCode) {
            try {
                return Language.valueOf(languageCode.toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(languageCode + " is not a valid or supported language code.");
            }
        }
    }
