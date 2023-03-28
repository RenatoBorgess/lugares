package br.com.clickbus.controller;
import java.time.LocalDateTime;

public class LugarResponse {
	
	private String slug;
	private LocalDateTime criadoEm;
	private LocalDateTime atualizadoEm;
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public LocalDateTime getCriadoEm() {
		return criadoEm;
	}
	public void setCriadoEm(LocalDateTime criadoEm) {
		this.criadoEm = criadoEm;
	}
	public LocalDateTime getAtualizadoEm() {
		return atualizadoEm;
	}
	public void setAtualizadoEm(LocalDateTime atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}
}
	
	
	
	
