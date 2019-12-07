package JavaCommands;

import Secrets.Secret;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class MST extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if(msg.length == 2 && msg[0].equalsIgnoreCase(Secret.Prefix + "java") && msg[1].equalsIgnoreCase("MST")) {
            event.getChannel().sendMessage("```java\n" +
                    "import java.io.BufferedReader;\n" +
                    "import java.io.InputStreamReader;\n" +
                    "import java.io.IOException;\n" +
                    "import java.util.ArrayList;\n" +
                    "import java.util.Collections;\n" +
                    "import java.util.HashMap;\n" +
                    "import java.util.StringTokenizer;\n" +
                    "public class MST {\n" +
                    "\t//This is a data structure that comes in almost every coding competition\n" +
                    "\t//Input =>\n" +
                    "\t/*\n" +
                    "\t[number of nodes(n)] [number of edge(5)]\n" +
                    "\t[first node] [second node] (These are the nodes you are connecting) [weight of the edge]\n" +
                    "\t\"Same thing *n* times\"\n" +
                    "\t\"Same thing until BufferedReader reads \"0 0\"...\n" +
                    "\tOutput =>\n" +
                    "\t[sum of the weights]\n" +
                    "\t[edges of MST in lexographical order]\n" +
                    "\t\"Same thing for all trees inputted\"" +
                    "\t*/\n" +
                    "    public static int[] set;\n" +
                    "    public static void main(String[] args) throws IOException {\n" +
                    "        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));\n" +
                    "        HashMap<Integer, String> map;\n" +
                    "        ArrayList<Integer> ar;\n" +
                    "        ArrayList<String> edges;\n" +
                    "        while(true) {\n" +
                    "            boolean flag = true;\n" +
                    "            map = new HashMap<>();\n" +
                    "            ar = new ArrayList<>();\n" +
                    "            StringTokenizer st = new StringTokenizer(bf.readLine());\n" +
                    "            int n = Integer.parseInt(st.nextToken());\n" +
                    "            int m = Integer.parseInt(st.nextToken());\n" +
                    "            if(n == 0 && m == 0) {\n" +
                    "                break;\n" +
                    "            }\n" +
                    "            set = new int[n];\n" +
                    "            for(int i=0; i<n; i++) {\n" +
                    "                set[i] = i;\n" +
                    "            }\n" +
                    "            for(int i=0; i<m; i++) {\n" +
                    "                st = new StringTokenizer(bf.readLine());\n" +
                    "                int n1 = Integer.parseInt(st.nextToken());\n" +
                    "                int n2 = Integer.parseInt(st.nextToken());\n" +
                    "                String e = n1 + \" \" + n2;\n" +
                    "                int w = Integer.parseInt(st.nextToken());\n" +
                    "                ar.add(w);\n" +
                    "                map.put(w, e);\n" +
                    "            }\n" +
                    "            Collections.sort(ar);\n" +
                    "            int tw = 0;\n" +
                    "            edges = new ArrayList<>();\n" +
                    "            int ne = 0;\n" +
                    "            for(int j=0; j<m; j++) {\n" +
                    "                int node = ar.get(j);\n" +
                    "                String edge = map.get(node);\n" +
                    "                st = new StringTokenizer(edge);\n" +
                    "                int n1 = Integer.parseInt(st.nextToken());\n" +
                    "                int n2 = Integer.parseInt(st.nextToken());\n" +
                    "                String temp = Math.min(n1, n2) + \" \" + Math.max(n1, n2);\n" +
                    "                if(find(n1) != find(n2)) {\n" +
                    "                    merge(n1, n2);\n" +
                    "                    edges.add(temp);\n" +
                    "                    tw += node;\n" +
                    "                    ne++;\n" +
                    "                } else {\n" +
                    "                    break;\n" +
                    "                }\n" +
                    "            }\n" +
                    "            if(ne == n-1) {\n" +
                    "                System.out.println(tw);\n" +
                    "            } else {\n" +
                    "                System.out.println(\"Impossible\");\n" +
                    "                flag = false;\n" +
                    "            }\n" +
                    "            if(flag) {\n" +
                    "                Collections.sort(edges);\n" +
                    "                for(int i=0; i<edges.size(); i++) {\n" +
                    "                    System.out.println(edges.get(i));\n" +
                    "                }\n" +
                    "            }\n" +
                    "        }\n" +
                    "    }\n" +
                    "    public static int find(int node) {\n" +
                    "        if(set[node] == node) {\n" +
                    "            return node;\n" +
                    "        }\n" +
                    "        int tmp = find(set[node]);\n" +
                    "        set[node] = tmp;\n" +
                    "        return tmp;\n" +
                    "    }\n" +
                    "    public static void merge(int a, int b) {\n" +
                    "        a = find(a);\n" +
                    "        b = find(b);\n" +
                    "        set[a] = b;\n" +
                    "    }\n" +
                    "}" +
                    "```").queue();
        }
    }
}
