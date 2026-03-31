# 🚀 Algorithm Deep-Dive Archive
> **"단순히 숫자를 채우는 1일 1문제가 아닌, 원리를 파헤치고 내실을 다지는 알고리즘 공략집"**

본 레포지토리는 자료구조의 이해를 바탕으로, 주요 알고리즘 유형을 **기초부터 심화까지 단계별(3단계)로 격파**하며 기술적 근거를 가진 해결 능력을 기르는 것을 목표로 합니다.

---

## 📌 공략 원칙 (Strategy)
1. **한 놈만 팬다**: 특정 유형을 선정하면 해당 알고리즘의 골드 레벨 문제까지 막힘없이 풀 수 있을 때까지 집중 공략합니다.
2. **기술적 근거 제시**: "왜 이 알고리즘인가?"에 대해 시간 복잡도($O(N)$)와 제약 조건을 바탕으로 분석합니다.
3. **Java Clean Code**: 백준용 코드라도 가독성을 챙기며, 메서드 분리와 효율적인 입출력(`BufferedReader`)을 지향합니다.
4. **회고의 기록**: 한 번에 통과하지 못한 이유와 최적화 포인트를 반드시 기록하여 '나만의 비법서'로 만듭니다.

---

## 🗺️ 알고리즘 정복 로드맵 (Roadmap)

| 단계 | 공략 유형 (Category) | 상태 | 핵심 타겟 문제 (기초 3선) |
| :-- | :--- | :--: | :--- |
| **01** | **기초 (Fundamentals)** | 🏃 | [10870](https://www.acmicpc.net/problem/10870), [15649](https://www.acmicpc.net/problem/15649), [2798](https://www.acmicpc.net/problem/2798) |
| **02** | **탐색 & 정렬 (Searching)** | 📅 | [1920](https://www.acmicpc.net/problem/1920), [3273](https://www.acmicpc.net/problem/3273), [2805](https://www.acmicpc.net/problem/2805) |
| **03** | **그래프 탐색 (Traversal)** | 📅 | [1260](https://www.acmicpc.net/problem/1260), [2667](https://www.acmicpc.net/problem/2667), [7576](https://www.acmicpc.net/problem/7576) |
| **04** | **동적 계획법 (DP)** | 📅 | [1463](https://www.acmicpc.net/problem/1463), [2579](https://www.acmicpc.net/problem/2579), [1149](https://www.acmicpc.net/problem/1149) |
| **05** | **최단 경로 (Path)** | 📅 | [1753](https://www.acmicpc.net/problem/1753), [11404](https://www.acmicpc.net/problem/11404), [1916](https://www.acmicpc.net/problem/1916) |
| **06** | **그리디 & 응용 (Greedy)** | 📅 | [11047](https://www.acmicpc.net/problem/11047), [1931](https://www.acmicpc.net/problem/1931), [1541](https://www.acmicpc.net/problem/1541) |

---

## 📂 디렉토리 구조 (Structure)

```text
.
├── 01_Fundamentals/          # 재귀, 브루트포스, 시간 복잡도
│   ├── BJ15649_N과M_1/        # [문제번호_문제명]
│   │   ├── Main.java         # 제출용 Java 코드
│   │   └── Analysis.md       # 접근 방식 및 회고
│   └── ...
├── 02_Searching/             # 이진 탐색, 투 포인터, 슬라이딩 윈도우
├── 03_Graph_Traversal/       # BFS, DFS 응용
└── ...