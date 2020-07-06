class Node
  attr_accessor :value, :left, :right
  def initialize(value)
    @value = value
    @left = nil
    @right = nil
  end
end

def check(a,b)
  return true if (a == nil && b == nil) 
  if a.value == b.value
    return check(a.left,b.left) && check(a.right,b.right)
  else
    return false
  end
end


def solution(a,b)
  return false if (a == nil && b != nil)
  return true if check(a,b) 
  return solution(a.left,b) || solution(a.right,b)
end

def driver
  a = Node.new 4
  a.left = Node.new 5
  a.left.left = Node.new 6
  a.left.right = Node.new 7
  a.right = Node.new 8
  a.right.right = Node.new 9
  a.right.left = Node.new 10
  b = Node.new 8
  b.right = Node.new 9
  b.left = Node.new 10
  puts solution a,b
end


driver

# A faster way would be to find out the inorder and preorder traversal of trees and check if one is a subarray of the other.