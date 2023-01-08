const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

solution(input);
function solution(input) {
  let N = input.shift() * 1;
  let check = Array.from({ length: N + 1 }, () => 0);
  check[1] = 1;
  const graph = new Array(N + 1);
  for (let i = 1; i <= N; i++) {
    graph[i] = [];
  }
  for (let i = 0; i < N - 1; i++) {
    const [a, b] = input[i].split(" ").map(Number);
    graph[a].push(b);
    graph[b].push(a);
  }
  //   console.log(graph);
  function bfs() {
    const queue = [];
    check[1] = 1;
    for (let next of graph[1]) {
      // next(child) 노드 값의 인덱스에 1(부모 노드)값을 넣어주고, 큐에 넣어준다.
      check[next] = 1;
      queue.push(next);
    }
    while (queue.length) {
      const node = queue.shift();
      for (let next of graph[node]) {
        // 노드를 순회하면서, 방문한 노드라면 건너뛴다.
        if (check[next]) continue;
        check[next] = node; // 위와 같이 next 인덱스에는 node(부모 노드)값을 넣는다.
        queue.push(next);
      }
    }
  }
  bfs();
  check = check.slice(2);
  let result = "";
  check.forEach((e) => (result += `${e}\n`));
  console.log(result.trim());
}
