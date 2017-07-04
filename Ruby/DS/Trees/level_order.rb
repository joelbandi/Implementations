class Node

  attr_accessor :value, :left, :right
  def initialize(value)
    @value = value
    @left = nil
    @right = nil
  end

end

def levelOrderTraversal(root)
  q = []
  q << root
  until(q.empty?) do
    for i in 1..q.size
      tmp = q.shift
      print tmp.value
      q << tmp.left if tmp.left
      q << tmp.right if tmp.right
      print "\n"
    end
  end
end


n = Node.new 5
n.left = Node.new 1
n.right = Node.new 6


levelOrderTraversal n