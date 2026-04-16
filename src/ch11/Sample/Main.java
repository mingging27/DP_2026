package ch11.Sample;

public class Main {
    public static void main(String[] args) {
        System.out.println("Making root entries...");
        Directory rootdir = new Directory("root");
        Directory bindir = new Directory("bin");
        Directory tmpdir = new Directory("tmp");
        Directory usrdir = new Directory("usr");
        Directory pmj = new Directory("pmj");

        rootdir.add(bindir);
        rootdir.add(tmpdir);
        rootdir.add(usrdir);
        rootdir.add(pmj);

        bindir.add(new File("vi", 10000));
        bindir.add(new File("latex", 20000));
        pmj.add(new File("pmj1", 100));
        pmj.add(new File("pmj2", 650));
        pmj.add(new File("pmj3", 40));
        rootdir.printList();
        System.out.println();

        System.out.println("Making user entries...");
        Directory youngjin = new Directory("youngjin");
        Directory gildong = new Directory("gildong");
        Directory dojun = new Directory("dojun");
        usrdir.add(youngjin);
        usrdir.add(gildong);
        usrdir.add(dojun);
        youngjin.add(new File("diary.html", 100));
        youngjin.add(new File("Composite.java", 200));
        gildong.add(new File("memo.tex", 300));
        dojun.add(new File("game.doc", 400));
        dojun.add(new File("junk.mail", 500));
        rootdir.printList();
    }
}
