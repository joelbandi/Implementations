class Node

  attr_accessor :value, :left, :right
  def initialize(value)
    @value = value
    @left = nil
    @right = nil
  end

end

def list_of_depths(root)
  # return an array of arrays
  q = []
  res = []
  q << root
  until q.empty? do
    s = q.size
    tmp_res = []
    for i in 1..s
      tmp = q.shift
      tmp_res << tmp
      q << tmp.left if tmp.left
      q << tmp.right if tmp.right
    end
    res << tmp_res
  end
  res
end

n = Node.new 5
n.left = Node.new 1
n.right = Node.new 6

a = list_of_depths n
for i in a
  for j in i
    print j.value
  end
  puts ""
end

