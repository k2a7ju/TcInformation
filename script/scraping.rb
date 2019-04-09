require 'open-uri'
require 'nokogiri'
require 'kconv'
require "fileutils"
require "erb"
require "csv"

class Script
  def self.scraping arg
    if !validate(arg)
      p 'args error'
      exit
    end
    csv = CSV.open('output.csv','w')
    url = 'https://techcrunch.com/' + arg + '/'
    doc = parse_html(url)


    # p doc.css('.content')
    doc.css('.content').css('.post-block').each do |node|

      # タイトル取得
      title = node.css('.post-block__title__link').inner_text.gsub(/\n/, '').gsub(/\t/, '')

      # 本文取得
      content =  node.css('.post-block__content').inner_text.gsub(/\n/, '').gsub(/\t/, '')

      # リンク取得
      link = node.css('.post-block__title__link')[0][:href]

      csv.puts [title,content,link]

    end
    csv.close

  end

  private
  def self.parse_html url
    html = open(url, "r:binary").read
    doc = Nokogiri::HTML(html.toutf8, nil, 'utf-8')
    doc
  end

  private
  def self.validate arg
    category = ['startups','apps','gadgets','video','podcasts','extracrunch','events']
    category.include?(arg)
  end
end

arg = ARGV[0]
Script.scraping(arg)
