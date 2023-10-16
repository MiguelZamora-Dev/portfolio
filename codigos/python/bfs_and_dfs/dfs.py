stack = []
visited = []

class Node:
    data = 0
    adjacents = []

    def __init__(self, data, adjacents):
        self.data = data
        self.adjacents = adjacents

def dfs ():
    if len(stack) > 0:
        actual = stack[-1]
        print("Processing: ", actual.data)
        visited.append(actual)
        stack.pop(-1)
        for adjacent in actual.adjacents:
            if adjacent not in visited and adjacent not in stack:
                stack.append(adjacent)
        print("Stack state: ", end="")
        for element in stack:
            print(element.data, end="|")
        print()
        dfs()

if __name__ == "__main__":
    root = Node(10, [])
    node11 = Node(11, [])
    node5 = Node(5, [])
    node12 = Node(12, [])
    node4 = Node(4, [])
    node3 = Node(3, [])
    node7 = Node(7, [])
    node6 = Node(6, [])

    root.adjacents = [node11, node5, node12]
    node11.adjacents = [root, node5, node7, node3]
    node3.adjacents = [node11]
    node7.adjacents = [node11, node6]
    node5.adjacents = [root, node11, node6]
    node6.adjacents = [node5, node7]
    node12.adjacents = [root, node4]
    node4.adjacents = [node12]

    stack.append(node3)
    dfs()
