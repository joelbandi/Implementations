class Node
  attr_accessor :right,:left,:value
  def initialize(value)
    @value = value
    @left = nil
    @right =nil
  end
end


def validate_bst(root)

  return true if root.nil? # temrinating condition

  left = root.left.nil? ? -Float::INFINITY : root.left.value
  right = root.right.nil? ? Float::INFINITY : root.right.value

  root_valid = (left <= root.value && root.value <= right)
  return false unless root_valid
  children_valid = validate_bst(root.left) && validate_bst(root.right)
  return children_valid
end


a = Node.new 4
a.left = Node.new 3
a.right = Node.new 6

puts validate_bst a