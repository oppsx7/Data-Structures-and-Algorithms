import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static class Path {
        private Path root;
        private String wholePath;
        private Map<String, Path> mapOfDirectories = new TreeMap<>();
    }

    static class System {
        private Path currentPath;

        public System() {
            currentPath = new Path();
            currentPath.wholePath = "/";
            currentPath.root = null;
        }

        public void mkDir(String name) {
            if (currentPath.mapOfDirectories.containsKey(name)) {
                System.out.println("Directory already exists");
            } else {
                Path tempPath = new Path();
                tempPath.root = currentPath;
                tempPath.wholePath = currentPath.wholePath + name + '/';
                currentPath.mapOfDirectories.put(name, tempPath);
            }
        }

        void pwd() {
            System.out.println(currentPath.wholePath);
        }

        void ls() {
            for (Map.Entry<String, Path> entry : currentPath.mapOfDirectories.entrySet()) {
                System.out.print(entry.getKey() + " ");
            }
        }

        void cd(String input) {
            if (input.equals("..")) {
                if (currentPath.root != null)
                    System.out.println("No such directory");
                else currentPath = currentPath.root;
            } else {
                if (currentPath.mapOfDirectories.containsKey(input))
                    currentPath = currentPath.mapOfDirectories.get(input);
                else
                    System.out.println("No such directory");
            }
        }
    }

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int N = input.nextInt();
        System fileSystem = new System();
        for (int i = 0; i < N; i++) {
            String keyWord = input.next();
            String path = input.nextLine();
            if (keyWord.equals("mkdir"))
                fileSystem.mkDir(path);
            else if (keyWord.equals("cd"))
                fileSystem.cd(path);
            else if (keyWord.equals("ls"))
                fileSystem.ls();
            else if (keyWord.equals("pwd"))
                fileSystem.pwd();
        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
