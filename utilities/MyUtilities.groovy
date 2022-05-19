package utilities

class MyUtilities {
  static void createFolder(def dsl, String folderName) {
      dsl.folder(folderName) {}
  }
}
