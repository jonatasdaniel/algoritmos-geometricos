class Point
	attr_accessor :x, :y

	def initialize(x, y)
		@x, @y = x, y
	end
	
	def to_s
	  "x:#{x} , y:#{y} - "
	end
end

class GrahamScan
  attr_reader :points
  
  def initialize(points=[])
    @points = points
  end

	def <<(point)
		@points << point
	end
  
  def start
    @points.sort! {|a, b| a.x <=> b.x}
    
    superiores = [@points.last, @points.reverse[1]]
    
		for i in 3..@points.size do
      superiores << @points[i]
      
      while superiores.size > 2 and direction(superiores.last, superiores.reverse[1], superiores.reverse[2]) >= 0
        superiores.delete_at(superiores.size-2)
      end
    end
    
    inferiores = [@points.last, @points.reverse[1]]

		for i in @points.size-1..0 do
			inferiores << @points[i]

			while inferiores.size > 2 and direction(inferiores.last, inferiores.reverse[1], inferiores.reverse[2]) >= 0
        inferiores.delete_at(inferiores.size-2)
      end	
		end

		superiores.delete_at 0
		superiores.delete_at superiores.size-1

    new_points = [superiores, inferiores]
    new_points
  end
  
  def direction(p1, p2, p3)
		if p1.nil?
			puts "p1"
		end
		if p2.nil?
			"puts p2"
		end
		if p3.nil?
			"puts p3"
		end
    (p2.x - p1.x) * (p3.y - p1.y) - (p2.y - p1.y) * (p3.x - p1.x)
  end
  
  def to_s
    @points.each do |o|
      returned << o.to_s
    end
    returned
  end
end

graham_scan = GrahamScan.new

(0..50).each do
	p = Point.new(rand(50), rand(50))
	puts "adding #{p.x} #{p.y}"
	graham_scan << p
end

puts "before #{graham_scan.points}"
points = graham_scan.start
puts "after #{points}"
