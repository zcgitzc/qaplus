package com.qaplus.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;

public class FestivalUtil {

	/**
	 * 获取所有节日
	 * 
	 * @return
	 */
	public static List<Festival> getAllFestival() {
		Connection connection = Jsoup.connect("http://hao.360.cn/rili/")
				.timeout(5000);
		Document doc;
		List<Festival> allFestivals = new ArrayList<Festival>();
		try {
			doc = connection.get();
			Element eleAllFestival = doc.getElementById("dateAllFestival");
			List<TextNode> allFestivalTextNodes = eleAllFestival.textNodes();
			for (TextNode textNode : allFestivalTextNodes) {
				String text = textNode.text();
				String[] items = text.split(" ");
				for (String item : items) {
					String[] result = item.split(",");
					if (result.length > 2) {
						Festival festival = new Festival();
						String date = result[0];
						if (date.indexOf("|") != -1) {
							date = date.substring(0, date.indexOf("|"));
						}
						if (NumberUtils.isNumber(date)) {
							festival.setDate(date);
						}

						String startYear = result[2];
						festival.setStartYear(startYear);
						festival.setName(result[1]);
						allFestivals.add(festival);
					}

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allFestivals;
	}

	/**
	 * 获取国家法定节假日
	 */
	public static List<Festival> getLegalFestival() {
		Connection connection = Jsoup.connect("http://hao.360.cn/rili/")
				.timeout(5000);
		Document doc;
		List<Festival> festivals = new ArrayList<Festival>();
		try {
			doc = connection.get();
			// 查看所有的HTML
			// System.out.println(doc);
			Element legalFestival = doc.getElementById("dateFestival");
			List<TextNode> legalFestivalTextNodes = legalFestival.textNodes();

			for (TextNode textNode : legalFestivalTextNodes) {
				String text = textNode.text();
				String[] items = text.split(" ");
				for (String item : items) {
					Festival festival = new Festival();
					String[] result = item.split("\\|\\|");
					festival.setDate(result[0]);
					festival.setName(result[1]);
					festivals.add(festival);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return festivals;
	}

	public static void main(String[] args) {
		System.out.println(getLegalFestival());
	}
}
