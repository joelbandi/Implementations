class Node
  attr_accessor :value, :left, :right
  def initialize(value)
    @value = value
    @left = nil
    @right = nil
  end

end



def check_balanced(root)
  #returns a boolean
  if depth_and_balanced(root) == Float::INFINITY
    return false
  else
    return true
  end
  
end



def depth_and_balanced(root)
  return 0 if root.nil?

  left = depth_and_balanced(root.left)
  right = depth_and_balanced(root.right)

  if [right,left].include? Float::INFINITY
    return Float::INFINITY
  elsif (right-left).abs > 1
    return Float::INFINITY
  else
    return 1+[left,right].max
  end
  
end



n = Node.new 5
n.left = Node.new 6
n.right = Node.new 4
n.left.left = Node.new 2
n.left.right = Node.new 3

n.right.left = Node.new 5
# n.right.left.left = Node.new 100
# un/comment the above line for true/false
puts check_balanced n