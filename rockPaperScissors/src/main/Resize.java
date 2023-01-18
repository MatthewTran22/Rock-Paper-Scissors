package main;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Resize {
private ImageIcon image;
private int length;
private int height;

	public Resize(ImageIcon image, int length, int height)
{
	this.image = image;
	this.length = length;
	this.height = height;
}
	public ImageIcon modified()
	{
		Image r = image.getImage();
		Image modified = r.getScaledInstance(length, height, java.awt.Image.SCALE_SMOOTH);
		image = new ImageIcon(modified);
		return image;
		
	}
}
